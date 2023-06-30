package org.adt.core.adt.TPOpuntos;

import org.adt.core.adt.implementation.dynamic.LinkedList;

import java.util.Random;

public class SetOfRepeated implements ISetOfRepeated {
    private CountNode first;
    private int count;

    @Override
    public void add(int a, int b) {
        if (this.first == null) {
            this.first = new CountNode(a, b, null);
            this.count = this.count+b;
            return;
        }

        if (this.first.getValue() == a) {
            this.first.setCantidad(this.first.getCantidad() + b);
            this.count += b;
            return;
        }

        CountNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                candidate.setCantidad(candidate.getCantidad() + b);
                this.count += b;
                return;
            }
        }
        candidate.setNext(new CountNode(a, b, null));
        this.count += b;
    }

    @Override
    public void remove(int a) {
        if (this.first==null) {
            return;
        }

        if (this.first.getValue() == a) {
            if(this.first.getCantidad()-1!=0) {
                this.first.setCantidad(this.first.getCantidad()-1);
                this.count--;
            }else{
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        CountNode backup = this.first;
        CountNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                if(this.first.getCantidad()-1!=0) {
                    candidate.setCantidad(candidate.getCantidad()-1);
                    this.count--;
                }else{
                    backup.setNext(candidate.getNext());
                    this.count--;
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        CountNode TF = this.first;
        LinkedList list= new LinkedList();
        if(this.first.getNext()==null){
            int indexRandom= (new Random()).nextInt(0, list.size());
            return list.get(indexRandom);
        }
        while(TF!=null){
            for(int i=0;i<TF.getCantidad();i++){
                list.add(TF.getValue());
            }
            TF = TF.getNext();
        }
        int indexRandom= (new Random()).nextInt(0, list.size());
        return list.get(indexRandom);
    }
}
