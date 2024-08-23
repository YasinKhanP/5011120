public class FactoryMethodPatternExample {

    // Document interface
    public interface Document {
        void open();
        void close();
    }

    // Concrete Document classes
    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word document.");
        }

        @Override
        public void close() {
            System.out.println("Closing Word document.");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF document.");
        }

        @Override
        public void close() {
            System.out.println("Closing PDF document.");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel document.");
        }

        @Override
        public void close() {
            System.out.println("Closing Excel document.");
        }
    }

    // Abstract DocumentFactory class
    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete DocumentFactory classes
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Test class to demonstrate Factory Method Pattern
    public static class FactoryMethodTest {
        public static void main(String[] args) {
            // Create a factory for Word documents
            DocumentFactory wordFactory = new WordDocumentFactory();
            Document wordDoc = wordFactory.createDocument();
            wordDoc.open();
            wordDoc.close();

            // Create a factory for PDF documents
            DocumentFactory pdfFactory = new PdfDocumentFactory();
            Document pdfDoc = pdfFactory.createDocument();
            pdfDoc.open();
            pdfDoc.close();

            // Create a factory for Excel documents
            DocumentFactory excelFactory = new ExcelDocumentFactory();
            Document excelDoc = excelFactory.createDocument();
            excelDoc.open();
            excelDoc.close();
        }
    }
}
