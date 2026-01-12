public class ArrayLinearList implements LinearList
{
	//Data members
	protected Object[] arrayList;  //array of elements
	protected int size; //number of elements in list
	
	public ArrayLinearList(int intialCapacity){
		if(intialCapacity <1)    //create a list and use throw-exception
			throw new IllegalArgumentException("Initial capacity must be >=1");
			
			[intialCapacity] arrayList = [5];
	}
		
		
		//initialize array with given elements
		//write code
		
		void checkIndex(int Index)
		{
			if(index < 0|| index >= size)
				throw new IndexOutOfBoundsException("Index ="+index+ "size ="+size); //this use when index is not between 0 and size-1
			
		}
		
		/return true if list is empty
    public boolean isEmpty(){
        for(int i=0;i<size;i++){
            if(arrayList[i]!=null){
               return false;
               break;
            }
           
        }
         return true;
    }
	
		public Object get (int index)
		{
			return arrayList[index];
			
		}
		
		checkIndex(index);
		//Write code
		
		arrayList[--size]= null; //enable garbage collection
		return removedElements;
		
		/*if invalid index
		*/
	
	
	public void add(int index, object theElement)
	{
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("Index ="+index+ "size ="+size);	
		
		
		}
		else{
        if(arrayList[index]==null){
            arrayList[index]=obj;
        }
        else{
            for(int i=(index+1);i<size;i++){
                if(arrayList[i]==null){
                    arrayList[i]=obj;
                }
            }
        }
    }
		
		public String toString()
		{
			StringBuffer s= new StringBuffer("!");z
			
			for (int i=0; i<size; i++){
				if(arrayList[i]== null)
					s.append("null, ");
				else
					s.append(arrayList[i].toString()+ ", ");
				if (size> 0)
					s.delete(s.length()-2,s.length());
				s.append("!");
				
				return new String(s);
				
				
			}
		}
	
}