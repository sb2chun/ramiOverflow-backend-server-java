package com.miracom.backendramioverflow.posts.entity.conditions;

public enum PostTypesEnum {

    QUESTION(1),ANSWER(2);

    PostTypesEnum(int value){
        this.value = value;
    }

    private final int value;
    public int value(){
        return value;
    }
}
