package de.telran.action;

import de.telran.FileAction;
import de.telran.FileOperations;
import java.util.List;

public class ReplaceFileAction extends FileAction {

    private final String pattern;
    private final String target;

    public ReplaceFileAction(FileOperations fileOperations, String pattern, String target) {
        super(fileOperations);
        this.pattern = pattern;
        this.target = target;
    }

    /**
     * Replace all occurences of 'pattern' to 'target'
     *
     * @param text
     * @return
     */
    @Override
    protected List<String> perform(List<String> text) {
        for (int i = 0; i < text.size(); i++){
            if (text.get(i).equals(pattern)){
                text.set(i, target);
            }
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplaceFileAction)) return false;

        ReplaceFileAction that = (ReplaceFileAction) o;

        if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
        return target != null ? target.equals(that.target) : that.target == null;
    }

    @Override
    public int hashCode() {
        int result = pattern != null ? pattern.hashCode() : 0;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
    }
}
