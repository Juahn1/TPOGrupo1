package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IMultipleDictionary;
import org.adt.core.adt.implementation.BaseMultipleDictionaryTest;

public class MultipleDictionaryTest extends BaseMultipleDictionaryTest {

    @Override
    public IMultipleDictionary getDictionary() {
        return new MultipleDictionary();
    }
}
