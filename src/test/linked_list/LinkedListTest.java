package linked_list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LinkedListTest {

    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();
    LinkedList list3 = new LinkedList();
    LinkedList list4 = new LinkedList();
    LinkedList list5 = new LinkedList();

    public LinkedListTest() {
    }

    private void headOnly(LinkedList list) {
        list.addInTail(new Node(0));
    }

    private void headAndTail(LinkedList list) {
        list.addInTail(new Node(0));
        list.addInTail(new Node(9));
    }

    private void tenDifferentNodesList(LinkedList list) {
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(i));
        }
    }

    private void allTenNodesAreSameList(LinkedList list) {
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(0));
        }
    }

    private void halvesAreDifferentNodesAreSameList(LinkedList list) {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                list.addInTail(new Node(0));
            } else {
                list.addInTail(new Node(9));
            }
        }
    }

    @BeforeEach
    public void fillLists() {
        headOnly(list1);
        headAndTail(list2);
        tenDifferentNodesList(list3);
        allTenNodesAreSameList(list4);
        halvesAreDifferentNodesAreSameList(list5);
    }

    @AfterEach
    public void clearLists() {
        list1 = new LinkedList();
        list2 = new LinkedList();
        list3 = new LinkedList();
        list4 = new LinkedList();
        list5 = new LinkedList();
    }

    @Test
    public void testFindAll() {
        ArrayList<Node> actual1 = list1.findAll(0);
        ArrayList<Node> actual2 = list1.findAll(1);
        ArrayList<Node> actual3 = list2.findAll(0);
        ArrayList<Node> actual4 = list2.findAll(9);
        ArrayList<Node> actual5 = list2.findAll(5);
        ArrayList<Node> actual6 = list3.findAll(0);
        ArrayList<Node> actual7 = list3.findAll(3);
        ArrayList<Node> actual8 = list3.findAll(9);
        ArrayList<Node> actual9 = list3.findAll(11);
        ArrayList<Node> actual10 = list4.findAll(0);
        ArrayList<Node> actual11 = list4.findAll(1);
        ArrayList<Node> actual12 = list5.findAll(0);
        ArrayList<Node> actual13 = list5.findAll(9);
        ArrayList<Node> actual14 = list5.findAll(3);
        ArrayList<Node> actual15 = list5.findAll(12);

        assertEquals(List.of(new Node(0)), actual1);
        assertEquals(List.of(), actual2);
        assertEquals(List.of(new Node(0)), actual3);
        assertEquals(List.of(new Node(9)), actual4);
        assertEquals(List.of(), actual5);
        assertEquals(List.of(new Node(0)), actual6);
        assertEquals(List.of(new Node(3)), actual7);
        assertEquals(List.of(new Node(9)), actual8);
        assertEquals(List.of(), actual9);
        assertEquals(List.of(new Node(0), new Node(0), new Node(0),
                new Node(0), new Node(0), new Node(0), new Node(0),
                new Node(0), new Node(0), new Node(0)), actual10);
        assertEquals(List.of(), actual11);
        assertEquals(List.of(new Node(0), new Node(0), new Node(0),
                new Node(0), new Node(0)), actual12);
        assertEquals(List.of(new Node(9), new Node(9), new Node(9),
                new Node(9), new Node(9)), actual13);
        assertEquals(List.of(), actual14);
        assertEquals(List.of(), actual15);
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testRemoveAll() {
    }

    @Test
    public void testClear() {
    }

    @Test
    public void testCount() {
    }

    @Test
    public void testInsertAfter() {
    }
}