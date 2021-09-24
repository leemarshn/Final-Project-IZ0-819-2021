#NIO.2
##### Non blocking input output 

* Symbolic Links -> a reference or pointer to another file or directory
* Relative Paths -> src/package does not start with a slash(/)
* Absolute Paths -> / starts from the root

### Path Interface - java.nio.file - java.base
* it describes a files location within the directory structure
* It is the cornerstone of the NIO.2 API, it kind of replaces the java.io.File class and it has support for symbolic links.
* Path instances are immutable

* You might wonder, why is Path an interface? When a Path is created, the JVM returns a file system�"specific implementation, such as a Windows or Unix Path class. In the vast majority of circumstances, we want to perform the same operations on the Path , regardless of the file system. By providing Path as an interface using the factory pattern, we avoid having to write complex or custom code for each type of file system.

##### creating a path
* using the factory method -> of() ->  `public static Path of(String	first, String... more)`
* passing an instance of the URI Class to the factory method of() -> `path p1 = path.of(new URI("file:/PATH/PATH"))` a URI begins with a schema that indicates the resource path followed by a path
* Obtaining a path using the paths class - method get() -> `path p1 = Paths.get("path/p2")` you can also pass an instance of the uri to the gt method of the Paths class
* obtaining a path from the FileSystems class: the FileSystems.getDefault() is an abstract method in the FileSystems class which returns an instance of FileSystem. The FileSystem Class includes methods for working with FileSystem directly. getPath(String path..) method is in the FileSystem class and returns a instance of the path interface -> `Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");`
* obtaining a path from the java.io.File class -> `File	file	=	new	File("husky.png"); - Path	path	=	file.toPath();`
  
 

#####Path Methods
* toString()
* int getNameCount()
* Path getName(int index)
* Path subPath(int beginIndex, int endIndex) - 0-indexed & does not include the root
* Path getFileName()
* Path getParent() - does not print if no parent
* Path getRoot() - prints null if not absolute path
* boolean isAbsolute()
* Path toAbsolute()
* Path resolve(Path other) - you cannot combine two absolute paths using resolve
* Path resolve(String path) - join two paths `path1.resolve(path2)`
`Path	path3	=	Path.of("/turkey/food");
System.out.println(path3.resolve("/tiger/cage"));`
`// /tiger/cage`
* Path relativize() - `path1.relativize(path2)` - you have two paths and you want to know how many steps it woul take from one path to the other
* Path normalize() - `path1.normalize()` - removes redudant symbols where neccesary 
* `Path toRealPath(LinkOption... options)` throws IOException - eliminates any redundant path symbols, joins relative apth with current working directory and throws an exception if the path does not exist

### Operating on files and directories
##### Files.Class
* static boolean exists(Path path, LinkOption... options)
* `static boolean isSame(Path path1, Path path2)` throws IOException - if two paths are equal it will return true withouth checking if the objects exist - symbolic links resolve to true 
* `static Path createDirectory(FileAttribute<?>... attr)` throws IOException - throws an exception if already exists or path leading to it does not exist
* `static Path CreateDirectories(FileAttribute<?>... attr)` throws IOException - creates directory inline with any non-existing directories - if all directories exists it will complete without doing anything
* static Path copy(Path target, Path source, CopyOption... options) throws IOExceeption - without the REPLACE_EXISTING option copy with throw an exception if the file already exists
* `Files.copy(Paths.get("book.txt"),	
        Paths.get("movie.txt"),
			StandardCopyOption.REPLACE_EXISTING);`
			
* static long copy(InputStream in, Path target, CopyOption... options) throws IOException
* static long copy(Path source, OutputStream out) throws IOException

* `try	(var	is	=	new	FileInputStream("source-data.txt"))	{
			//	Write	stream	data	to	a	file
			Files.copy(is,	Paths.get("/mammals/wolf.txt"));
}
Files.copy(Paths.get("/fish/clown.xsl"),	System.out);`
* static Path move(Path source, Path target, CopyOption... options) throws IOException
* `Files.move(Path.of("mouse.txt"),	Path.of("gerbil.txt"),
			StandardCopyOption.ATOMIC_MOVE);`
			
* static void delete(Path path) throws IOException
* static boolean deleteIfExists(Path path) IOException
* static BufferedReader newBufferedReader(Path path) throws IOException
* static BufferedWriter newBufferedWriter(Path path, OpenOption... options) throws IOException

* `var	path	=	Path.of("/animals/gopher.txt");
  try	(var	reader	=	Files.newBufferedReader(path))	{
  			String	currentLine	=	null;
  			while((currentLine	=	reader.readLine())	!=	null)
  						System.out.println(currentLine);
  }`
  
* static List<String> readAllLines(Path path) throws IOEXception - stores all the contents of the file in memory all at once
* `var	path	=	Path.of("/animals/gopher.txt");
final	List<String>	lines	=	Files.readAllLines(path);
lines.forEach(System.out::println);`

###file attributes
* `boolean isRegular(Path path, LinkOption... options) `-> a regular file is one that has contents it is posible for isRegular to return true for a symbolic link since java will perform check on the target
* boolean isSymbolicLink(Path path)
* boolean isHidden -> throws IOException
* boolean isWrittable
* boolean isReadable
* boolean isDirectory
* static long size(Path path) throws IOException : to get the accurate size of a directory use walk method
* static FileTime getLastModified(Path path) throws IOException

#####reading and modifying fileAttributes
* `public static <A extends BasicFileAtrributes> readAttributes(Path p, Class<A> type, LinkOption... options)` for reading file attributes - 
* `public static <V extends FileAttributeView> getFileAttributeView`

#### Applying functional programing 
* `static Stream<Path> walk(Path path, FileVisitOption... option) throws IOException `- remember to use `FileVisitOption` to avoid circular paths - java.io uses depth first search - i.e from the root to the node
* static Stream<Path> walk(Path path, int maxDepth, FileVisitOption... option) throws IOException
* `static Stream<Path> list(Path dir) throws IOException `-> performs shallow copy
* `static Stream<Path> find(Path path, int maxDepth, BiPredicate<Path path, BasicFileAttributes attr> matcher, FileVisitOption... options) throws IOException`
* `static Stream<String> lines(Path path) throws IOExceptions`


