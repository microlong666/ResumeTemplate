package xyz.microloong.resumetemplate.dao;

import xyz.microloong.resumetemplate.bean.Skill;
import xyz.microloong.resumetemplate.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDaoImp implements BaseDao<Skill> {

    private static final String SQL_INSERT = "insert into kkb_skill(userid,keywords) values(?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_skill where userid=?";

    @Override
    public int insert(Skill skill) {
        Connection conn = DbUtil.getConn();
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1, skill.getUserId());
            state.setString(2, skill.getKeyWords());
            int row = state.executeUpdate();
            return row > 0 ? row : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, state, null);
        }
        return -1;
    }

    @Override
    public Skill findByUserId(int userId) {
        Connection conn = DbUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Skill skill = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1, userId);
            resultSte = state.executeQuery();
            if (resultSte.next()) {
                int id = resultSte.getInt("id");
                String keywords = resultSte.getString("keywords");
                skill = new Skill(id, userId, keywords);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, state, resultSte);
        }
        return skill;
    }
}
