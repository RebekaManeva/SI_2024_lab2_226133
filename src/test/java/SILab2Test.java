import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {
    @Test
    public void invalidNameTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0.2F));
        items.add(new Item(null, "04444", 82, 0.1F));
        items.add(new Item("leb", "05555", 43, 0.4F));
        items.add(new Item("voda", "06666", 23, 0.01F));
        items.add(new Item("", "07777", 135, 0.8F));
        SILab2.checkCart(items, 200);

        assertEquals("unknown", items.get(1).getName());
        assertEquals("unknown", items.get(4).getName());
    }

    @Test
    public void emptyCart() {
        List<Item> items = null;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 0));
        assertEquals("allItems list can't be null!", exception.getMessage());
    }

    @Test
    public void nullBarcodeTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0.2F));
        items.add(new Item("mleko", "04444", 82, 0.1F));
        items.add(new Item("leb", "05555", 43, 0.4F));
        items.add(new Item("voda", null, 23, 0.01F));
        items.add(new Item("kafe", "07777", 135, 0.8F));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 400));
        assertEquals("No barcode!", exception.getMessage());
    }

    @Test
    public void invalidBarcodeTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0.2F));
        items.add(new Item("mleko", "04444", 82, 0.1F));
        items.add(new Item("leb", "5$@55", 43, 0.4F));
        items.add(new Item("voda", "06666", 23, 0.01F));
        items.add(new Item("kafe", "07777", 135, 0.8F));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 400));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }


    @Test
    public void trueWithoutDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0));
        items.add(new Item("mleko", "04444", 82, 0));
        items.add(new Item("leb", "05555", 43, 0));
        items.add(new Item("voda", "06666", 23, 0));
        items.add(new Item("kafe", "07777", 135, 0));

        assertTrue(SILab2.checkCart(items, 400));
    }

    @Test
    public void falseWithoutDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0));
        items.add(new Item("mleko", "04444", 82, 0));
        items.add(new Item("leb", "05555", 43, 0));
        items.add(new Item("voda", "06666", 23, 0));
        items.add(new Item("kafe", "07777", 135, 0));

        assertFalse(SILab2.checkCart(items, 200));
    }

    @Test
    public void returnTrueTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0.2F));
        items.add(new Item("mleko", "04444", 82, 0.1F));
        items.add(new Item("leb", "05555", 43, 0.4F));
        items.add(new Item("voda", "06666", 23, 0.01F));
        items.add(new Item("kafe", "07777", 135, 0.8F));

        assertTrue(SILab2.checkCart(items, 400));
    }

    @Test
    public void returnFalseTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("oriz", "03333", 40, 0.2F));
        items.add(new Item("mleko", "04444", 82, 0.1F));
        items.add(new Item("leb", "05555", 43, 0.4F));
        items.add(new Item("voda", "06666", 23, 0.01F));
        items.add(new Item("kafe", "07777", 135, 0.8F));

        assertFalse(SILab2.checkCart(items, 4));
    }

    @Test
    public void priceMoreThan300() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("mleko", "04444", 400, 0.1F));
        assertFalse(SILab2.checkCart(items, 3));
    }

    @Test
    public void discountLessOrEqualToZero() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("mleko", "04444", 82, 0));
        assertFalse(SILab2.checkCart(items, 30));
    }

    @Test
    public void barcodeStartsWithZero() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("mleko", "44444", 82, 0.1F));
        assertFalse(SILab2.checkCart(items, 3));
    }

    @Test
    public void allConditionsMet() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("mleko", "04444", 82, 0.1F));
        assertTrue(SILab2.checkCart(items, 400));
    }
}
