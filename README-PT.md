# Utilitários inseguros

Permite um acesso mais conveniente à API insegura do java.

## Como usar

#### Acesso ao objeto
Para acessar os objetos, use a classe __ObjectMemory__. Os métodos requerem a passagem de referência de objeto e deslocamento de campo. Para obter o deslocamento de campo, use o método __fieldOffset__.
```
SomeClass obj = new SomeClass();
obj.field1 = 123;
long longField = ObjectMemory.fieldOffset(SomeClass.class, "field1");
long value = ObjectMemory.getLong(obj, longField);
```

#### Acesso à matriz
Para acessar arrays use a classe __ArrayMemory__. Os métodos exigem a passagem de referência de matriz e deslocamento ou índice. O deslocamento é calculado como deslocamento para o primeiro elemento
e índice do elemento multiplicado pelo tamanho do elemento. Para obter o deslocamento do primeiro elemento, use o método __firstElementOffset__.
###### Por índice
```
int value = ArrayMemory.getInt(array, 4);
```
###### Por compensação
```
long offset = ArrayMemory.firstElementOffset() + 2 * SystemTypeSizes.intSize();
int value = ArrayMemory.getInt(array, offset);
```
Tamanhos para tipos estão disponíveis através da classe __SystemTypeSizes__.

#### Acesso fora do heap
Para acessar a memória nativa, use a classe __OffHeapMemory__.
```
long address = OffHeapMemory.allocate(100 * SystemTypeSizes.intSize());
long offset = SystemTypeSizes.intSize() * 10;
OffHeapMemory.setInt(address + offset, 123);
int value = OffHeapMemory.getInt(address + offset);
OffHeapMemory.free(address);
```
Esteja ciente de que a memória nativa deve ser liberada manualmente.

#### Cercas de memória
A classe __MemoryFence__ permite classificar cercas de memória. Existem cercas de armazenamento, carregamento e completo fornecidas pela JVM.
```
MemoryFence.full();
```

## Instalação
Os pacotes estão disponíveis no repositório __Maven Central__.
###### Especialista
```
<dependency>
    <groupId>io.github.thepun</groupId>
    <artifactId>unsafe-utils</artifactId>
    <version>1.1</version>
</dependency>
```
######Gradle
```
compile group: 'io.github.thepun', name: 'unsafe-utils', version: '1.1'
```
