package com.manager.info.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.manager.info.dell.infomanagerapp.db.InfoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "INFO_ENTITY".
*/
public class InfoEntityDao extends AbstractDao<InfoEntity, Long> {

    public static final String TABLENAME = "INFO_ENTITY";

    /**
     * Properties of entity InfoEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Sn = new Property(1, String.class, "sn", false, "SN");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property ImageUrl = new Property(3, String.class, "imageUrl", false, "IMAGE_URL");
        public final static Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public final static Property Manufactures = new Property(5, String.class, "manufactures", false, "MANUFACTURES");
        public final static Property Cs_Mobile = new Property(6, String.class, "cs_Mobile", false, "CS__MOBILE");
        public final static Property Cs_Name = new Property(7, String.class, "cs_Name", false, "CS__NAME");
    }


    public InfoEntityDao(DaoConfig config) {
        super(config);
    }
    
    public InfoEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"INFO_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SN\" TEXT UNIQUE ," + // 1: sn
                "\"NAME\" TEXT," + // 2: name
                "\"IMAGE_URL\" TEXT," + // 3: imageUrl
                "\"DESCRIPTION\" TEXT," + // 4: description
                "\"MANUFACTURES\" TEXT," + // 5: manufactures
                "\"CS__MOBILE\" TEXT," + // 6: cs_Mobile
                "\"CS__NAME\" TEXT);"); // 7: cs_Name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INFO_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, InfoEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String sn = entity.getSn();
        if (sn != null) {
            stmt.bindString(2, sn);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(4, imageUrl);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        String manufactures = entity.getManufactures();
        if (manufactures != null) {
            stmt.bindString(6, manufactures);
        }
 
        String cs_Mobile = entity.getCs_Mobile();
        if (cs_Mobile != null) {
            stmt.bindString(7, cs_Mobile);
        }
 
        String cs_Name = entity.getCs_Name();
        if (cs_Name != null) {
            stmt.bindString(8, cs_Name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, InfoEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String sn = entity.getSn();
        if (sn != null) {
            stmt.bindString(2, sn);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(4, imageUrl);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        String manufactures = entity.getManufactures();
        if (manufactures != null) {
            stmt.bindString(6, manufactures);
        }
 
        String cs_Mobile = entity.getCs_Mobile();
        if (cs_Mobile != null) {
            stmt.bindString(7, cs_Mobile);
        }
 
        String cs_Name = entity.getCs_Name();
        if (cs_Name != null) {
            stmt.bindString(8, cs_Name);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public InfoEntity readEntity(Cursor cursor, int offset) {
        InfoEntity entity = new InfoEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // sn
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imageUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // description
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // manufactures
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // cs_Mobile
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // cs_Name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, InfoEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSn(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImageUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setManufactures(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCs_Mobile(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCs_Name(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(InfoEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(InfoEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(InfoEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}