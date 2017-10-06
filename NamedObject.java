/** This class creates a NamedObject that contains a name and an object. It contains the following Methods:
 *Constructor:
 *	This sets up the NamedObject and verifies that the name is not null.
 *
 *getName():
 *	Returns the specified name in the form of a string. Used in the .equals() method to compare equality.
 *
 *getObject():
 *	Returns the specified object. Used in the .equals() method to compare equality.
 *
 *setName():
 *	Allows the user to change the name of a NamedObject.
 * 
 *equals():
 *	Overrides the .equals() method and checks for the equality of both the name and object of a NamedObject.
 *
 *hashCode():
 *	Overrides the .hashCode() method. It returns the hashCode of an object. If two objects are equal, it returns the same hash value.
 *
 *chain():
 *	Accepts an array of Strings and chains them together as separate objects.
 *
 *unchain():
 *	Accepts a chain of separate objects and returns an array of Strings.
 *
 *Author:
 *	Caitlyn Greenburg
 *
 *Last Update: August 31st, 2017
 */


package assignment01;

import java.util.Scanner;

public class NamedObject {
	
	private String name;
	private Object object;
	private String[] data;
	
	/** Constructs a NamedObject from a given name and object. The name must not be null, but the object may be null.
	 * 
	 * @param
	 * 		name -Any non-null String
	 * 		object -Any object
	 * @throws
	 * 		java.lang.IllegalArgumentException() - if the name is null.
	 */
	public NamedObject(java.lang.String name, java.lang.Object object){
		
		//Throws an error if the name is null.
		if(name == null){		
			throw new java.lang.IllegalArgumentException("The name cannot be null!");		
		}
		
		 this.name = name;	
		 this.object = object; 		
	}
	
	/** Returns the name of this NamedObject
	 * 
	 * @return the String name.
	 */
	public java.lang.String getName(){
		return name.toString();				//returns the desired name as a String.
	}
	
	/** Returns the object.
	 * 
	 * @return object stored in this new NamedObject.
	 */
	public java.lang.Object getObject(){
		return object; 				//returns the desired object.
	}
	
	/**Changes the name of this named object to a new name. The new name must not be null. 
			 * @param
			 *		newName - a non-null String
			 * @throws 
			 *		java.lang.IllegalArgumentException() - if the new name is null.
			 * @param newName
			 */
	public void setName(java.lang.String newName){
		
		//Check the new name. If null, throw an exception.
		if(newName == null){
			throw new java.lang.IllegalArgumentException("The new name cannot be null!");
		}
		
		this.name = newName; 		//sets the name to the new desired name.
	}
	

	/**Returns true iff this NamedObject and the other NamedObject have the same names
	 * and objects (using .equals). Null enclosed objects are only considered equal to other null 
	 * object references.
	 * 
	 * Overrides: 
	 * 		equals in class java.lang.Object
	 * @return 
	 * 		bool	
	 * 
	 */
	public boolean equals(java.lang.Object other){
		
		//If current object IS other, return true.
		if(this == other){
			return true;		
		}
		
		//Checks to see if the argument is an instance of the NamedObject class.
		if(!(other instanceof NamedObject)){	
			return false;
		}
		
		NamedObject temp = (NamedObject) other;		//Making other into a temp NamedObject for comparison.
		
		//if one is null and the other is not, false.
		if((this.getObject() == null) && (temp.getObject() != null)){
			return false;
		}
		
		//if both are null, check the names.
		if((this.getObject() == null) && (temp.getObject() == null)){
			if(this.getName() == temp.getName()){
				return true;
			}
		}
		
		//if neither are null, but equal, check the names.
		if((this.getObject() != null) && (temp.getObject() != null)){
			if(this.getObject() == temp.getObject()){
				if(this.getName() == temp.getName()){
					return true;
				}
			}
		}
		
		return false;						//else it returns false.
	}
	
	/**Returns a hash value for this NamedObject. This method is guaranteed to be consistent with equals: Two equal 
	 * NamedObjects will always produce equal hash values. There are no guarantees about the hash values of unequal NamedObjects.
	 * 
	 * Overrides:
	 * 		hashCode in class java.lang.Object
	 * @return
	 *		the hash value for this object
	 */
	public int hashCode(){
		
		if(this.getObject() == null){		//If the object is null, assign an integer.
			return 13;
		}
		
		return (int) this.getObject();		//Otherwise explicitly cast Object to an int and return the hashCode();
		
	}
	
	
	/**
	 * Given an array of non-null Strings, this method will return a chain of NamedObjects containing 
	 * the Strings as Names. This method creates one NamedObject per String, using each String in the 
	 * array as the Name for each NamedObject. Each NamedObject will store another NamedObject in its 
	 * enclosed object field such that the NamedObject with the name (data[n]) will have as it's enclosed 
	 * object the NamedObject with the name (data[n+1]). The very last NamedObject with the name (data[data.length-1]) 
	 * will have a null enclosed object. The returned NamedObject will have the name (data[0]) and will 
	 * be chained to the rest of the NamedObjects.
	 * @param
	 * 		data - An non-empty array of non-null Strings
	 * @return
	 *		a chain of named objects whose names match the Strings in data
	 * @throws
	 * 		java.lang.IllegalArgumentException() - if the data array is empty or a String is null
	 * 		java.lang.NullPointerException() - if the data array is null
	 */
	public static NamedObject chain(java.lang.String[] data){
		//Throws error if the data String array is null
		if(data==null){
			throw new java.lang.NullPointerException("Your array cannot be null.");
			}
		
		//if the array is not null...
		if(data != null){
			//if the array is not empty
			if(data.length == 0){
				throw new java.lang.IllegalArgumentException("You must have content in the array.");
			}
			
			NamedObject newObject;
			NamedObject Current;
			NamedObject finalObject;
			
			for( int i=0; i < data.length - 1; i++){
				
				Scanner dataArray = new Scanner(data[i]);
				newObject = new NamedObject(data[i].toString(), dataArray.next());
				finalObject.add(data[i]);
				dataArray.close();
			}
			return finalObject;
		}
		
	}
	
	/**This method extracts and returns the names stored in a chain of NamedObjects. Each NamedObject in the chain 
	 * must have an object that is another NamedObject, or null (to end the chain). The returned array will have one 
	 * element per NamedObject in the chain. The elements will contain the names from this chain in the order that 
	 * they appear in the chain. (The name extracted from the parameter 'chain' will be in the 0th array position, etc.) 
	 * If 'chain' is null, a zero-length array is returned.
	 * 
	 * @param 
	 * 		chain - A NamedObject chained to 0 or more other chained NamedObjects
	 * @return
	 * 		an array of Strings corresponding to the names in the chain
	 * @throws
	 * 		java.lang.ClassCastException - if the chain does not contain only NamedObjets
	 */
	public static java.lang.String[] unchain(NamedObject chain){
		//Go through the NamedObject to see how many elements it has.
		//create array with size given from the first walk through.
		//Place objects in the array.
		//return an array of objects.
	}
}
