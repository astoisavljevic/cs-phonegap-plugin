/**
 * 
 */
package rs.in.staleksit.cs.phonegap.demo3.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * @author a.stoisavljevic
 *
 */
public class SimplePlugin extends CordovaPlugin {
	
	private static final String SIMPLE_ACTION = "simple";
	
	@Override
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		boolean result = false;
		Log.d("execute", "-+- triggered SimplePLugin action:" + action + " -+-");
		if (SIMPLE_ACTION.equals("simple")) {
			String macAddress = this.getMacAddress();
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, macAddress);
            callbackContext.sendPluginResult(pluginResult);
			result = true;
		}
		return result;
	}
	
	public String getMacAddress() {
        String macAddress = null;
        WifiManager wm = (WifiManager) cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
        macAddress = wm.getConnectionInfo().getMacAddress();
        
        Log.d("getMacAddress", "macAddress" + macAddress);
        if (macAddress == null || macAddress.length() == 0) {
            macAddress = "00:00:00:00:00:00";
        }

        return macAddress;		
	}
	

}
