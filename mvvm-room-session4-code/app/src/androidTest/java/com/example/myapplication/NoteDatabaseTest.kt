//package com.example.myapplication
//
//import androidx.room.Room
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.platform.app.InstrumentationRegistry
//import com.example.myapplication.roomcode.database.Note
//import com.example.myapplication.roomcode.database.NoteDao
//import com.example.myapplication.roomcode.database.NoteDatabase
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import java.io.IOException
//
//@RunWith(AndroidJUnit4::class)
//class NoteDatabaseTest {
//
//    private lateinit var noteDao: NoteDao
//    private lateinit var db: NoteDatabase
//
//    @Before
//    fun createDb() {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//        // Using an in-memory database because the information stored here disappears when the
//        // process is killed.
//        db = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java)
//            // Allowing main thread queries, just for testing.
//            .allowMainThreadQueries()
//            .build()
//        noteDao = db.noteDao
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun insertAndGetNote() {
//        val note = Note(title = "Angular", body = "Angular is a frontend framework")
//        noteDao.insert(note)
//        val noteToCheck = noteDao.getNote(1)
//        Assert.assertEquals(noteToCheck?.title, "Angular")
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun getAllNotes() {
//        val notes = noteDao.getAllNotes()
//    }
//}