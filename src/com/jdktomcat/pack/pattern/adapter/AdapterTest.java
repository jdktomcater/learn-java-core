package com.jdktomcat.pack.pattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.editTextFile();
        targetable.editWordFile();

        Targetable objectTargetable = new ObjectAdapter(new Source());
        objectTargetable.editTextFile();
        objectTargetable.editWordFile();

        Sourceable sourceable1 = new SourceSub1();
        sourceable1.editTextFile();
        Sourceable sourceable2 = new SourceSub2();
        sourceable2.editWordFile();
    }
}
