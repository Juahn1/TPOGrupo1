package org.adt.core.adt.utils;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.Queue;
import org.adt.core.adt.implementation.normal.Stack;

public class QueueOfQueue {
    private IQueue[] arrayofQueues= new Queue[10000]; //SI no anda volver a 3 el 10000
    private int count=0;

    public QueueOfQueue(){
    }

    public void add(IQueue queue){
        this.arrayofQueues[this.count]=queue;
        this.count++;
    }


    public void remove(){
        if(count==0){
            System.out.println("Error, no se puede desacolar una cola vacía");
            return;
        }
        for(int i=0; i<arrayofQueues.length -1;i++){
            this.arrayofQueues[i]=this.arrayofQueues[i+1];
        }
        this.count--;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public IQueue getFirst() {
        if (this.count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return null;
        } else {
            return this.arrayofQueues[0];
        }
    }

    public static QueueOfQueue concatenate(QueueOfQueue queueOfQueue){
        IQueue newQueue = new Queue();
        int elemento;

        while(!queueOfQueue.isEmpty()) {
            IQueue currentQueue = queueOfQueue.getFirst();

            while (!currentQueue.isEmpty()) {
                elemento = currentQueue.getFirst();
                newQueue.add(elemento);
                currentQueue.remove();
            }
            queueOfQueue.remove();
        }
        queueOfQueue.add(newQueue);
        return queueOfQueue;
    }

    public static IQueue flat(QueueOfQueue queueOfQueue){
        IQueue aux = new Queue();
        IQueue queue = new Queue();
        int elemento;
        while(!queueOfQueue.isEmpty()){
            aux=queueOfQueue.getFirst();
            while(!aux.isEmpty()){
                elemento = aux.getFirst();
                queue.add(elemento);
                aux.remove();
            }
            queueOfQueue.remove();
        }
        return queue;
    }

     public static QueueOfQueue reverseWithDepth(QueueOfQueue queueOfQueue){
        QueueOfQueue qoqAux = new QueueOfQueue();
        StackOfQueues soq = new StackOfQueues();
        IQueue queueAux;
        IStack invertir = new Stack();
        int elemento;

        while(!queueOfQueue.isEmpty()) {
            queueAux = new Queue();
            while (!queueOfQueue.getFirst().isEmpty()) {
                elemento = queueOfQueue.getFirst().getFirst();
                invertir.add(elemento);
                queueOfQueue.getFirst().remove();
            }
            while (!invertir.isEmpty()) {
                queueAux.add(invertir.getTop());
                invertir.remove();
            }
            //Aca deberia ir una pila de colas que añada las queueAux, luego qoqAux añade esta pila hasta terminarla
            soq.add(queueAux);
            queueOfQueue.remove();
        }
        while(!soq.isEmpty()){
            qoqAux.add(soq.getTop());
            soq.remove();
        }
        //Hacer un Stack of queues
        return qoqAux;
    }






    public static void printQoq(QueueOfQueue queueOfQueue) {
        while(!queueOfQueue.isEmpty()) {
            IQueue currentQueue = queueOfQueue.getFirst();
            while (!currentQueue.isEmpty()) {
                int elemento = currentQueue.getFirst();
                System.out.println(elemento + " ");
                currentQueue.remove();
            }
            queueOfQueue.remove();
        }
    }

    public static void printQueue(IQueue queue){
        IQueue aux = new Queue();
        while(!queue.isEmpty()){
            System.out.println(queue.getFirst());
            aux.add(queue.getFirst());
            queue.remove();
        }
    }

    public static void main(String[] args) {
        IQueue cola1= new Queue();
        IQueue cola2= new Queue();
        IQueue cola3= new Queue();
        IQueue cola4= new Queue();
        QueueOfQueue qoq = new QueueOfQueue();
        cola1.add(1);
        cola1.add(2);
        cola1.add(3);
        cola1.add(4);
        cola2.add(10);
        cola2.add(20);
        cola2.add(30);
        cola2.add(40);
        cola3.add(100);
        cola3.add(200);
        cola3.add(300);
        cola3.add(400);
        cola4.add(1000);
        cola4.add(2000);
        cola4.add(3000);
        cola4.add(4000);
        qoq.add(cola1);
        qoq.add(cola2);
        qoq.add(cola3);
        qoq.add(cola4);
        /*Parte de concatenar*/
        printQoq(concatenate(qoq));
        /*Parte de flat*/
        printQueue(flat(qoq));
        /*Parte Reverse*/
        printQoq(reverseWithDepth(qoq));

    }
}



