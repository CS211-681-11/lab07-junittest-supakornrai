package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest
{
    @Test
    @DisplayName("ทดสอบการเพื่มนักเรียนคนใหม่")
    void testAddNewStudentAndFind()
    {
        StudentList list = new StudentList();
        list.addNewStudent("6710405524", "Supakorn");
        Student s1 = list.findStudentById("6710405524");
        assertNotNull(s1);
        assertEquals("Supakorn", s1.getName());
        assertEquals(0.0, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการกรองนักเรียน")
    void testFilterByName() {
        StudentList list = new StudentList();
        list.addNewStudent("6710405524", "Supakorn");
        list.addNewStudent("6710456789", "Yosapat");
        list.addNewStudent("6710467924", "Pisit");

        StudentList filtered = list.filterByName("a");
        assertEquals(2, filtered.getStudents().size());

        filtered = list.filterByName("P");
        assertEquals(1, filtered.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย ID")
    void testFindStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("6710405524", "Supakorn");
        list.addNewStudent("6710456789", "Yosapat");
        list.addNewStudent("6710467924", "Pisit");

        assertNotNull(list.findStudentById("6710405524"));
        assertNotNull(list.findStudentById("6710456789"));
        assertNotNull(list.findStudentById("6710467924"));
        assertNull(list.findStudentById("9999999999"));
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนนักเรียนด้วย ID")
    void testGiveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("6710405524", "Supakorn");

        list.giveScoreToId("6710405524", 90.0);
        Student s = list.findStudentById("6710405524");
        assertEquals(90.0, s.getScore());

        list.giveScoreToId("999", 50.0);
        assertEquals(90.0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนด้วย ID ")
    void testViewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("6710405524", "Supakorn", 90.0);

        String grade = list.viewGradeOfId("6710405524");
        assertNotNull(grade);

        assertNull(list.viewGradeOfId("999999999"));
    }
}