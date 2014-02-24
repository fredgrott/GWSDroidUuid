package gws.grottworkshop.gwsdroiduuidapl;

import java.util.UUID;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

/**
 * GWSAndroidUuidFactory class sets up an unique
 * Android ID that uses encryption and avoids
 * including  androidID,etc unencrypted.
 *
 * Requires the read phone state permission to be set in the android manifest.
 *
 * Usage:
 *
 *   In your application class
 * <code>
 *    onCreate{
 *        GWSAndroidUuidFactory myUUId =new DeviceUuidFactory(context);
 *    }
 * </code>
 *
 *
 * @author fredgrott
 *
 */
public class GWSAndroidUuidFactory {

	protected static final String PREFS_FILE = "device_uuid.xml";
    protected static final String PREFS_DEVICE_UUID = "device_uuid";

    protected volatile static UUID uuid;

    public GWSAndroidUuidFactory(Context context) {
    	/**
    	 * uuid==null first time executed as in first time
    	 * application class initializes this class.
    	 */
    	if( uuid ==null ) {
    		 synchronized (GWSAndroidUuidFactory.class) {
    			 if( uuid == null) {
    				 final SharedPreferences prefs = context.getSharedPreferences( PREFS_FILE, 0);
                     final String id = prefs.getString(PREFS_DEVICE_UUID, null );
                     if (id != null) {
                         // Use the ids previously computed and stored in the prefs file
                         uuid = UUID.fromString(id);

                     } else {
                    	 final UUID randomUUID;
                    	 final String  androidID, deviceID, simSerialID;
                    	 final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    	 randomUUID = UUID.randomUUID();

                    	 androidID = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);

                    	 deviceID = tm.getDeviceId();

                    	 simSerialID = tm.getSimSerialNumber();
                    	 //two cases android 2.2 bug and emulator
                    	 if("9774d56d682e549c".equals(androidID) || androidID == null){
                    		 uuid = randomUUID;
                    		 prefs.edit().putString(PREFS_DEVICE_UUID, uuid.toString() ).commit();
                    	 }else{
                    		 if(deviceID ==null){
                    			 uuid = randomUUID;
                    			 prefs.edit().putString(PREFS_DEVICE_UUID, uuid.toString() ).commit();
                    		 }else{
                    			 // non phone device and if debugging with actual phone with no simcard
                    			 if(simSerialID == null){
                    				 uuid = randomUUID;
                    				 prefs.edit().putString(PREFS_DEVICE_UUID, uuid.toString() ).commit();
                    			 } else{
                    				 uuid = new UUID(androidID.hashCode(), ((long)deviceID.hashCode() << 32) | simSerialID.hashCode());
                    				 prefs.edit().putString(PREFS_DEVICE_UUID, uuid.toString() ).commit();
                    			 }
                    		 }
                    	 }


                     }
    			 }
    		 }
    	}

    }

    public UUID getDeviceUuid() {
        return uuid;
    }

}
