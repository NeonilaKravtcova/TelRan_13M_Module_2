package de.telran.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

/*    {
        IStringOperation upperCase = new UpperCaseSO();
        IStringOperation lowerCase = new LowerCaseSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);
        operationByName.put(lowerCase.getName(), lowerCase);
    }*/


    public OperationContext(Map<String, IStringOperation> operationByName){
        this.operationByName = operationByName;
    }


    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.operationByName = new HashMap<>();

        for (String operationPath : operationPaths) {

            IStringOperation operation = (IStringOperation) Class
                    .forName(operationPath)
                    .getConstructor()
                    .newInstance();

            operationByName.put(operation.getName(), operation);

        }
        // TODO compose 'operationByName' by the paths to the necessary operations
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
