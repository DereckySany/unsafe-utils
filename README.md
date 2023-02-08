# Unsafe utils 
*Read this in other languages: [English](README.md), [Portuguese](README-PT.md)

Allows more convenient access to java's Unsafe API.

## How to use

#### Object access
To access objects use __ObjectMemory__ class. Methods require to pass object reference and field offset. To get field offset use __fieldOffset__ method. 
```
SomeClass obj = new SomeClass();
obj.field1 = 123;
long longField = ObjectMemory.fieldOffset(SomeClass.class, "field1");
long value = ObjectMemory.getLong(obj, longField);
```

#### Array access
To access arrays use __ArrayMemory__ class. Methods require to pass array reference and offset or index. Offset is calculated as offset for first element  
and element index multiplied by element size. To get first element's offset use __firstElementOffset__ method.
###### By index 
```
int value = ArrayMemory.getInt(array, 4);
```
###### By offset 
```
long offset = ArrayMemory.firstElementOffset() + 2 * SystemTypeSizes.intSize();
int value = ArrayMemory.getInt(array, offset);
```
Sizes for types are available through __SystemTypeSizes__ class.  

#### Off heap access
To access native memory use __OffHeapMemory__ class. 
```
long address = OffHeapMemory.allocate(100 * SystemTypeSizes.intSize());
long offset = SystemTypeSizes.intSize() * 10;
OffHeapMemory.setInt(address + offset, 123);
int value = OffHeapMemory.getInt(address + offset);
OffHeapMemory.free(address);
```
Be aware native memory should be freed manually.

#### Memory fences
Class __MemoryFence__ allows to class memory fences. There are store, load and full fences provided by JVM.
```
MemoryFence.full();
```

## Installation
Packages are available through __Maven Central__ repository.
###### Maven 
```
<dependency>
    <groupId>io.github.thepun</groupId>
    <artifactId>unsafe-utils</artifactId>
    <version>1.1</version>
</dependency>
```
###### Gradle 
```
compile group: 'io.github.thepun', name: 'unsafe-utils', version: '1.1'
```
