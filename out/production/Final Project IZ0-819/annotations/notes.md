#ANNOTATIONS

* The purpose of annotations is to assign meta data to classes, methods, variable and other java types
* Metadata is data about data, it includes relationships, rules or properties surrounding an object
* Attribute data, is more of transactional data that makes up e.g. a sale complete.

##### Rules

* Annotations function more as interfaces: the difference between annotations and interfaces is that annotations can be passed in methods and other declarations while interfaces can only be used in classes, Also using Annotations you can pass values.
* The value of the annotation does not change with change in object reference
* an annotation ascribes custom information on the declaration where it is defined: i.e annotations can be applied to unrelated classes or variable
* Annotations are optional metadata and do not do anything
* You can remove annotations from the application and still it will compile, but adding Annotations can cause compile errors
* Annotations are not used when defined, it is up to the rest of the application or the underlying framework to enforce its use.


#### Creating Annotations

* `public @interface Example{}` - this is a marker interface since it does not take any values
* when using marker interfaces parentheses are optional e.g. `@Example` or `@Example()`

* An _Annotation element_ is on that store value about the particular usage of the annotation
* Parentheses are only optional if no values are included
* When declaring an Annotation, any element without a default value is considered required.
* each syntax is written _elementName = elementValue_
* The order does not matter
* Datatype compatibility is critical
* The default value MUST be a _non null value_  _constant_

* The element type of an annotation mus be a primitive type, a string, a class an enum another annotation or an array of this types.

#### Creating a `value element`
* this is when you want to infer to an element without the _elementName_  
`@Injured("Broken	Tail")	public	class	Monkey	{}`
* The annotation declaration must contain an element named `value() `which can be required or default
* The annotation declaration must not contain any other values that are required
* The annotation usage must not provide values for any other elements

### Assertions

* An assertion is a boolean expression which you insert in your code where you expect the condition to be true
* you can turn on assertions in testing while leaving them off in production
* Assertions are used to verify the internal state of program while unit tests are used to test the behaviour
* When assertions are enabled and the boolean expression evaluates to force then _AssertionError_ is thrown at runtime
* Assertions are disabled by default to enable them - enableassertions or ues -ea use -da to disable them.

`java	-ea:com.demos...	-da:com.demos.TestColors	my.programs.Main`