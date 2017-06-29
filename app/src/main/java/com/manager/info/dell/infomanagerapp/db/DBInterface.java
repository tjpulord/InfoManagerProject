package com.manager.info.dell.infomanagerapp.db;

import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;

import com.manager.info.db.DaoMaster;
import com.manager.info.db.DaoSession;
import com.manager.info.db.InfoEntityDao;
import com.manager.info.dell.infomanagerapp.util.App;

import java.util.List;

/**
 * Description
 * <p>
 * Created by Liu Huanbin
 * 2017/6/23
 */

public class DBInterface {
    private static final String DB_NAME = "db_info.db";
    private static SQLiteDatabase writableDatabase;
    private static DaoSession writableSession;
    private static DBInterface dbInterface;
    private static DaoMaster.DevOpenHelper openHelper;

    static {
        if (dbInterface == null) {
            dbInterface = new DBInterface();
            openHelper = new DaoMaster.DevOpenHelper(App.getContext(), DB_NAME);
            writableDatabase = openHelper.getWritableDatabase();
        }
    }

    private DBInterface() {
    }

    /**
     * 获取单例对象的静态方法
     *
     * @return
     */
    public static DBInterface instance() {
        return dbInterface;
    }

    public void close() {
        if (openHelper != null) {
            openHelper.close();
            openHelper = null;
        }
    }

    /**
     * Query for writable DB
     */
    private DaoSession getWritableSession() {
        if (writableSession == null) {
            DaoMaster daoMaster = new DaoMaster(writableDatabase);
            writableSession = daoMaster.newSession();
        }
        return writableSession;
    }


    // 插入、更新 信息
    public void insertOrUpdateInfo(InfoEntity info) {
        if (info == null) {
            return;
        }
        InfoEntityDao dao = getWritableSession().getInfoEntityDao();
        dao.insertOrReplaceInTx(info);
    }

    // 查询信息
    public InfoEntity queryInfoByUniqueId(String sn) {
        InfoEntityDao dao = getWritableSession().getInfoEntityDao();
        List<InfoEntity> res = dao.queryBuilder().where(InfoEntityDao.Properties.Sn.eq(sn)).build().list();

        if (res == null || res.size() == 0) {
            return null;
        }
        return res.get(0);
    }

    public List<InfoEntity> queryAllInformations() {
        InfoEntityDao dao = getWritableSession().getInfoEntityDao();
        return dao.queryBuilder().build().list();
    }

    // 删除信息
    public void deleteInfoByUniqueId(Long sid) {
        InfoEntityDao dao = getWritableSession().getInfoEntityDao();
        dao.deleteByKey(sid);
    }
}
