package payload;

public  class PayLoads {

    public static String fnAddPlace(){
        return "{\n" +
                "    \"location\" : {\n" +
                "        \"lat\" : -38.383495,\n" +
                "        \"lng\" : 33.427326\n" +
                "    },\n" +
                "    \"accuracy\" : 50\n" +
                "    ,\"name\" :\"Orchid Whitefield\"\n" +
                "    ,\"phone number\" : \"9051566695\"\n" +
                "    ,\"address\" : \"E-1004, Hagadur Main Road\"\n" +
                "    ,\"types\" : [\n" +
                "        \"park\",\n" +
                "        \"home\"\n" +
                "    ],\n" +
                "    \"website\" :\"http//google.com\"\n" +
                "    ,\"language\" : \"French-IN\"\n" +
                "}";
    }

    public static String fnAddBook(String isbn, String aisle)
    {
        return "{\n" +
                "    \"name\":\"Learn Appium With Java\",\n" +
                "    \"isbn\":\""+isbn+"\",\n" +
                "    \"aisle\":\""+aisle+"\",\n" +
                "    \"author\":\"John foe\"\n" +
                "}";
    }


}
