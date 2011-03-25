import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class SVGStripesText extends WOComponent {

    public SVGStripesText(WOContext context) {
        super(context);
    }
    
    public boolean synchronizesVariablesWithBindings() {
	return false;
    }

}
