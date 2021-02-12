package de.telran.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;
    {

        //TODO add more operations here
        IStringOperation upperCase = new UpperCaseSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);
    }

        public IStringOperation getOperation(String name){
            return operationByName.get(name);
    }
}
