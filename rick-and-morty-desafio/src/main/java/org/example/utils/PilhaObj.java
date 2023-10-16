package org.example.utils;

import org.example.model.Location;

import java.util.ArrayList;
import java.util.List;

public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        this.pilha = (T[]) new Object[capacidade];
        this.topo = -1;
    }

    public Boolean isEmpty() {
        if (topo == -1){
            return true;
        }
        return false;
    }

    public Boolean isFull() {
        if (topo >= pilha.length - 1){
            return true;
        }
        return false;
    }

    public void push(T info) {
        if (!isFull()){
            pilha[++topo] = info;
        }else {
            throw new IllegalStateException("Pilha cheia");
        }
    }


    public T pop() {
        if (!isEmpty()){
            return pilha[topo--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()){
            return pilha[topo];
        }
        return null;
    }

    public List<T> displays() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i <= topo; i++){
            list.add(pilha[i]);
        }
        return list;
    }

    public String displaysInvert(Integer indice){
        String frase = pilha[indice].toString();
        String fraseInvertida = "";

        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida += frase.charAt(i);
        }
        return fraseInvertida;
    }

    public String displaysNormal(Integer indice){
        String frase = pilha[indice].toString();
        String fraseNormal = "";

        for (int i = 0; i < pilha.length; i++) {
            fraseNormal += frase.charAt(i);
        }
        return fraseNormal;
    }

    public T[] getPilha() {
        return pilha;
    }

    public int getTopo() {
        return topo;
    }
}
