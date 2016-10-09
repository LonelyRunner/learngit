package HeadFirst.factoryMode;

import java.util.Properties;

/**
 * Created by ZH on 2016/9/22.
 */
public class HairFactory {

    public static Hair makeHairByKey(String key){
        if("left".equals(key)){
            return new LeftHair();
        }

        if("right".equals(key)){
            return new RightHair();
        }

        return null;
    }

    public static Hair makeHairByClassName(String className)
            throws InstantiationException,IllegalAccessException,ClassNotFoundException{
        Hair hair = (Hair)Class.forName(className).newInstance();
        return hair;
    }

    public static Hair makeLeftHairByPrps()
            throws InstantiationException,IllegalAccessException,ClassNotFoundException{
        Properties properties = PropertiesReader.getProperties();
        String className = properties.getProperty("left");
        Hair hair = (Hair)Class.forName(className).newInstance();
        return hair;
    }
}
