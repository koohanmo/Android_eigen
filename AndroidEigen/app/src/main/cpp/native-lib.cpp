#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_tistory_coderkoo_androideigen_Ndkinitial_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
