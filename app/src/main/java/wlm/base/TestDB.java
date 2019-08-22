package wlm.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TestDB {
    private SqlLiteTool tool;
    private SQLiteDatabase dbw;
    String name;

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

    public String readSomeThing(String name) {
//        表名字加上条件
        Cursor c = dbw.rawQuery("SELECT * FROM person where name = ? ", new String[]{name});
        while (c.moveToNext()) {
            name = name + "______" + c.getString(c.getColumnIndex("name"));
            name = name + "______" + c.getString(c.getColumnIndex("age"));
            name = name + "______" + c.getString(c.getColumnIndex("sex"));
        }
        c.close();
        Log.e("结果", name);
        return name;
    }


    public void addData(String name, String age, String sex) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("sex", sex);
        dbw.insert("person", null, values);
    }


    public void upData(String condition, String conditionTxt, String sex) {
        ContentValues value = new ContentValues();
        value.put("sex", sex);
        condition = condition + "=?";
        dbw.update("person", value, condition, new String[]{conditionTxt});
    }


}
