public class DatosXml {

    public enum noticiasElement {

        PUBDATE("pubDate"), ITEM("item"), TITLE("title"),
        BODY("description"), BODYOPT("content:encoded"), AUTHOR("dc:creator"), LINK("link");
        private String name;

        private noticiasElement(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
