package alexjalg.compras.de.lista.app.com.applistadecompras.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by alejandro on 01/11/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    //private static String DB_PATH =  "/data/data/alexjalg.compras.de.lista.app.com.applistadecompras/databases/";
    private static String DB_PATH ;
    private static String DB_NAME = "dblistas.sqlite";
    private SQLiteDatabase database;
    private final Context context;
    public DataBaseHelper(Context context) {
        //super(context, name, factory, version);
        super(context, DB_NAME, null, 1);
        this.context=context;
        DB_PATH = context.getFilesDir().getAbsolutePath().replace("files", "databases")
                + File.separator;
        System.out.println(  DB_PATH   );
    }
    public void createDataBase()throws IOException{
        boolean dbExist = checkDataBase();
        SQLiteDatabase dbRead = null ;
        if(!dbExist){
            dbRead = this.getReadableDatabase();
            dbRead.close();
            try{
                copyDataBase();
            }catch (IOException e){
                throw new Error("Error copiando base de datos");
            }

        }

    }
    public boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        String path = DB_PATH+DB_NAME;
        try{
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            File dbFile = new File(path);
            return dbFile.exists();
        }
        if(checkDB != null ){
            checkDB.close();
        }
        return checkDB != null? true: false;
    }
    private void copyDataBase()throws IOException{
        InputStream input = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] bytes =  new byte[1024];
        int length;
        while((length= input.read(bytes)) != -1){
            if(length > 0){
                outputStream.write(bytes, 0, length);
            }
        }
        outputStream.flush();
        outputStream.close();
        input.close();
    }
    public void openDataBase()throws SQLException{
        String path = DB_PATH+DB_NAME;
        database= SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
    }
    public synchronized void close(){
        if(database!=null){
            database.close();
        }
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Colocar código SQL para crear la BD
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Código de actualización

    }
    public Cursor fethAllList() throws SQLException{
        Cursor cursor = database.rawQuery("SELECT * FROM listas", null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
