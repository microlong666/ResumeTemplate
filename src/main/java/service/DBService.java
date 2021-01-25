package service;

import bean.*;
import db.*;

public class DBService {
    private static final BaseDao<User> USER_DAO = new UserDaoImp();
    private static final BaseDao<Skill> SKILL_DAO = new SkillDaoImp();
    private static final BaseDao<Specialty> SPECIALTY_DAO = new SpecialtyDaoImp();
    private static final BaseDao<Work> WORK_DAO = new WorkDaoImp();
    private static final BaseDao<Edu> EDU_DAO = new EduDaoImp();

    public static int insertUser(User user) {
        return USER_DAO.insert(user);
    }

    public static int insertSkill(Skill skill) {
        return SKILL_DAO.insert(skill);
    }

    public static int insertSpecialty(Specialty specialty) {
        return SPECIALTY_DAO.insert(specialty);
    }

    public static int insertWork(Work work) {
        return WORK_DAO.insert(work);
    }

    public static int insertEdu(Edu edu) {
        return EDU_DAO.insert(edu);
    }

    public static Info find(int userId) {
        User user = USER_DAO.findByUserId(userId);
        if (user == null) {
            return null;
        }
        System.out.println(user);
        Skill skill = SKILL_DAO.findByUserId(userId);
        System.out.println(skill);
        Specialty specialty = SPECIALTY_DAO.findByUserId(userId);
        System.out.println(specialty);
        Work work = WORK_DAO.findByUserId(userId);
        System.out.println(work);
        Edu edu = EDU_DAO.findByUserId(userId);
        System.out.println(edu);
        return new Info(user, edu, skill, work, specialty);
    }
}
