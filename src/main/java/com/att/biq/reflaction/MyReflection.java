package com.att.biq.reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflection
{
	public static void main(String[] args)
	{
		// Obtain the class object if we know the name of the class
		Class person = Person.class;
		try
		{
			// get the absolute name of the class
			String personClassPackage = person.getName();
			System.out.println("Class Name is: " + personClassPackage);

			// get the simple name of the class (without package info)
			String rentalClassNoPackage = person.getSimpleName();
			System.out.println("Class Name without package is: " + rentalClassNoPackage);

			// get the package name of the class
			Package rentalPackage = person.getPackage();
			System.out.println("Package Name is: " + rentalPackage);

			// get all the constructors of the class
			Constructor[] constructors = person.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));

			// get constructor with specific argument
			Constructor constructor = person.getConstructor(String.class, String.class, Integer.TYPE);

			// initializing an object of the Person class
			Person newInstance = (Person) constructor.newInstance("eee", "eee", 34);

			// get all methods of the class including declared methods of
			// superclasses
			// in that case, superclass of Person is the class java.lang.Object
			Method[] allPersonMethods = person.getMethods();
			System.out.println("Methods are: " + Arrays.toString(allPersonMethods));
			for (Method method : allPersonMethods)
			{
				System.out.println("method = " + method.getName());
			}

			// get all methods declared in the class
			// but excludes inherited methods.
			Method[] declaredMethods = person.getDeclaredMethods();
			System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods)
			{
				System.out.println("method = " + dmethod.getName());
			}

			// get method with specific name and parameters
			Method oneMethod = person.getMethod("setAge", int.class);
			System.out.println("Method is: " + oneMethod);

			// call computeRentalCost method with parameter int
			oneMethod.invoke(newInstance, 4);

			// get all the parameters of computeRentalCost
			Class[] parameterTypes = oneMethod.getParameterTypes();
			System.out.println("Parameter types setAge are: " + Arrays.toString(parameterTypes));

			// get the return type of computeRentalCost
			Class returnType = oneMethod.getReturnType();
			System.out.println("Return type is: " + returnType);

			// gets all the public member fields of the class Person
			Field[] fields = person.getFields();

			System.out.println("Public Fields are: ");
			for (Field oneField : fields)
			{
				// get public field name
				Field field = person.getField(oneField.getName());
				// get private field name
				field.setAccessible(true);
				String fieldname = field.getName();
				System.out.println("Fieldname is: " + fieldname);

				// get public field type
				Object fieldType = field.getType();
				System.out.println("Type of field " + fieldname + " is: " + fieldType);

				// get public field value
				Object value = field.get(newInstance);
				System.out.println("Value of field " + fieldname + " is: " + value);

			}

			// How to access private member fields of the class

			// getDeclaredField() returns the private field
			Field privateField = Person.class.getDeclaredField("age");

			String name = privateField.getName();
			System.out.println("One private Fieldname is: " + name);

		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
}