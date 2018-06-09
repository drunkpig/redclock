package com.example.cxu.redclock;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.graphics.Color;
import android.widget.TextView;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class RedClock implements IXposedHookLoadPackage {
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		XposedBridge.log("REDCLOCK======1. "+lpparam.packageName);
		if (!lpparam.packageName.equals("com.android.systemui"))
			return;
		XposedBridge.log("REDCLOCK======2. "+lpparam.packageName);
		findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
			@Override
			protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				XposedBridge.log("REDCLOCK======3. ");
				TextView tv = (TextView) param.thisObject;
				String text = tv.getText().toString();
				tv.setText(text + " :)");
				tv.setTextColor(Color.RED);
				XposedBridge.log("REDCLOCK======4. ");
			}
		});
	}
}
