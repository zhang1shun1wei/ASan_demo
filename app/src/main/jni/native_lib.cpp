//
// Created by zhangshunwei on 10/21/21.
//

#include <jni.h>
#include <string>
#include <fstream>
#include <iostream>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_getStr1(JNIEnv *env, jclass clazz) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_getStr(JNIEnv *env, jclass clazz) {
    const char *ss = "这是从jni传来的字符串";
    jclass cls = (*env).FindClass("com/example/myapplication/Commond");
    jmethodID mid = (env)->GetStaticMethodID(cls, "commond2", "(Ljava/lang/String;)V");
    (env)->CallStaticVoidMethod(cls, mid, env->NewStringUTF(ss));
}

int myFree(int *p){
    free(p);
    p=NULL;
    return 0;
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_ProveCrash(JNIEnv *env, jclass clazz) {
    int *ptr = (int*)malloc(sizeof(int) * 3);
    myFree(ptr);
    myFree(ptr);
}