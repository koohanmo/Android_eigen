//
// Created by koohanmo on 2017-01-31.
//

#include <stdio.h>
#include <iostream>
#include "Eigen/Dense"
#include <jni.h>
#include <string>

using Eigen::MatrixXd;
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jintArray JNICALL
Java_com_tistory_coderkoo_androideigen_EigenStartActivity_matrixAddFromEigen
        (JNIEnv *env, jobject obj, jintArray m1, jintArray m2) {

    jint *m1_buf = env->GetIntArrayElements(m1,NULL);
    int m1Len = env->GetArrayLength(m1);

    jint *m2_buf = (*env).GetIntArrayElements(m2,NULL);
    int m2Len = env->GetArrayLength(m2);

    MatrixXd M1(2, 2);
    M1(0, 0) = m1_buf[0];
    M1(0, 1) = m1_buf[1];
    M1(1, 0) = m1_buf[2];
    M1(1, 1) = m1_buf[3];

    MatrixXd M2(2, 2);
    M2(0, 0) = m2_buf[0];
    M2(0, 1) = m2_buf[1];
    M2(1, 0) = m2_buf[2];
    M2(1, 1) = m2_buf[3];

    MatrixXd M3(2,2);
    M3 = M1*M2;

    env->ReleaseIntArrayElements(m1,m1_buf,0);
    env->ReleaseIntArrayElements(m2,m2_buf,0);

    jint retMat[4] = {M3(0,0),M3(0,1),M3(1,0),M3(1,1)};
    jintArray retMatArray = env->NewIntArray(4);
    if(NULL == retMatArray) return NULL;
    env->SetIntArrayRegion(retMatArray,0,4,retMat);
    return retMatArray;
}


#ifdef __cplusplus
}
#endif