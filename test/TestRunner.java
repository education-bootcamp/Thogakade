import com.seekerscloud.pos.db.HibernateUtil;
import org.hibernate.Session;

public class TestRunner {
    public static void main(String[] args) {
        check();
    }
    private static void check(){
        try(Session session= HibernateUtil.createSession()){
            System.out.println(session);
        }
    }
}
