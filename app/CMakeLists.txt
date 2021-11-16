cmake_minimum_required(VERSION 3.4.1)
# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.



find_library(log-lib log)

add_library(native-lib SHARED src/main/jni/native_lib.cpp)

target_compile_options(native-lib PUBLIC -fsanitize=address -fno-omit-frame-pointer)
set_target_properties(native-lib PROPERTIES LINK_FLAGS -fsanitize=address)


target_link_libraries(native-lib ${log-lib})