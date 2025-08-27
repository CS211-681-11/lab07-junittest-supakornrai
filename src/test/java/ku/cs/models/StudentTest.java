package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6710405524", "Supakorn");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710405524", "Supakorn");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบ ID ของผู้ใช้งาน")
    void testisId()
    {
        Student s = new Student("6710405524", "Supakorn");
        assertTrue(s.isId("6710405524"));
    }

    @Test
    @DisplayName("ทดสอบ Upper&Lower case ของผู้ใช้งาน")
    void testisNameContains()
    {
        Student s = new Student("6710405524", "Supakorn");
        assertTrue(s.isNameContains("sup"));
        assertTrue(s.isNameContains("PAK"));
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อของผู้ใช้งาน")
    void testchangeName()
    {
        Student s = new Student("6710405524", "Supakorn");
        s.changeName("John");
        assertEquals("John", s.getName());

        s.changeName("");
        assertEquals("John", s.getName());
    }


}