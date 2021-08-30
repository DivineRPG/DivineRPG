package divinerpg.util;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.config.*;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.filter.*;
import org.apache.logging.log4j.message.*;

@Plugin(name = "SpamFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE)
public class SpamFilter extends AbstractFilter {

    @Override
    public Filter.Result filter(LogEvent event) {
        Message message = event.getMessage();
        if (message != null) {
            if (message.getFormattedMessage().contains("Unknown structure piece")) {
                if (message.getFormattedMessage().contains("Unknown structure start: divinerpg:")) {
                    return Result.DENY;
                }
            }
        }

        return Result.NEUTRAL;
    }
}