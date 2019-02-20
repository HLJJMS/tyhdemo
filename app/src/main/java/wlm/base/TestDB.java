package wlm.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TestDB {
    private SqlLiteTool tool;
    private SQLiteDatabase dbw;
    String name ;
    public TestDB(Context context) {
        tool = new SqlLiteTool(context, "test", null, 1);
        dbw = tool.getWritableDatabase();
    }

    public void addSomeThing() {
        dbw.beginTransaction();
        dbw.execSQL("insert into person(name,age,sex) values(?,?,?)", new Object[]{"名字", "年龄", "性别"});
        dbw.setTransactionSuccessful();
        dbw.endTransaction();
    }

    public String readSomeThing() {
        Cursor c = dbw.rawQuery("SELECT * FROM person", null);
        while (c.moveToNext()){
            name=c.getString(c.getColumnIndex("name"));
        }
        c.close();
        return name;
    }
}
