package smsc_utility;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScenarioContext {
    private final static Map<String, Object> scenarioData = new ConcurrentHashMap<>();

    public void setContext(String key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }
        scenarioData.put(key, value);
        System.out.println("ScenarioContext SET: " + key + " -> " + value);
    }

    public static Object getContext(String key) {
        Object value = scenarioData.getOrDefault(key, null);
        System.out.println("ScenarioContext GET: " + key + " -> " + value);
        return value;
    }

    public static boolean containsKey(String key) {
        return scenarioData.containsKey(key);
    }

    public void removeContext(String key) {
        scenarioData.remove(key);
    }

    public void clearContext() {
        scenarioData.clear();
    }
}
