package HeadFirst.factoryMode;

import java.util.Properties;

public class PropertiesReader {

    public static Properties getProperties(){
        Properties props = new Properties();

        try{
            props.load(PropertiesReader.class.getClassLoader().getResourceAsStream("HeadFirst/factoryMode/type.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return props;
    }
}
