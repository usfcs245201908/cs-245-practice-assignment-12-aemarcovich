//import java.util.*;
//Alejandro Marcovich
public class Hashtable
{
    int tablesize;
    Node[] values;

    private class Node
    {
        String key;
        String value;
        Node next;

    public Node(String key, String value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
        }
    }

    Hashtable()
    {
        this.tablesize = 1000;
        this.values = new Node[1000];
    }

/*    Hashtable(int size)
    {
        this.tablesize = size;
        this.values = new Node[size];
    }*/
	/**
	* searches for a key or value that matches the given string
	*/
    public boolean containsKey(String key) {
        int hash = hash(key);
        if(values[hash] != null) {
            return true;
        }

        return false;
    }
	/**
	*returns value associated with the string key.
	*/
    public String get(String key)
    {
        int hash = hash(key);
        if(values[hash] != null)
        {
            Node temp = values[hash];
            while (temp != null)
            {
                if (temp.key.equals(key))
                {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

	/**
	*adds key/value pair to exisiting hashtable. Overrides is string already exist.
	*/
    public void put(String key, String value)
    {
        Node hashElement = new Node(key, value);
        int hash = hash(key);
        if(values[hash] == null)
        {
            values[hash] = hashElement;
        } 
        else
        {
            hashElement.next = values[hash];
            values[hash] = hashElement;
        }
    }
	/**
	*remove key/value pair and return value according to key
	*/
    public String remove(String key)
    {
        int hash = hash(key);
        if(values[hash] != null)
        {
            Node temp = values[hash];
            while (temp != null)
            {
                if (temp.key.equals(key))
                {
                    values[hash] = null;
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }
	/**
	*hash takes the string key and converts it into an a hashcode
	*/
    public int hash(String key)
    {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % tablesize;
    }

}