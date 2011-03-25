import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SimpleForumTemplate extends WOComponent {
        
    public SimpleForumTemplate(WOContext context) {
        super(context);
    }

    /*
    * non-synchronizing component
    */
    public boolean synchronizesVariablesWithBindings() {
        return false;
    }
    
    /*
    * stateless
    */
    public boolean isStateless() {
        return true;
    }
}
