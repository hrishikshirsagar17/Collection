/*There is an arraylist of song object { int song id , String songname , float volume } .
As song objects are added into list, volume variable of current object is increased by 2.
E.g. first song added will have volume 2 , second song will have volume 4 and so on.
But the when volume becomes divisible by 3. It gets reduced by 50% for that song (current object).
Again for next song onwards volume will increase by 2 and so on. 
Find out index of atleast one song object for which volume will be equal to or greater than 10. 
You have to accept only song id and song name from user. Volume will be set as per above logic.
e.g. first song added – 1 , ‘all is well’ , 2 second song – 2 , ‘e vatan’ , 3 third song - 3 , ‘lakshya to’ , 6 ..
now this volume is divisible by 3 so. This song’s volume will be reduced by 50% so will become 3. 
Now next song will have volume 3+2 = 5 and so on . Again when volume becomes 9 it will be reduced to 4.5.*/
package Collection_Test_4;
import java.util.*;

class Song
{
	private int song_id;
	private String songName;
	private float volume;

	public Song() {
	}

	public Song(int song_id, String songName, float volume) {
		super();
		this.song_id = song_id;
		this.songName = songName;
		this.volume = volume;
	}

	public int getsong_id() {
		return song_id;
	}

	public void setsong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	
	@Override
	public String toString() {
		return "Song [song_id=" + song_id + ", songName=" + songName + ", volume=" + volume + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		result = prime * result + song_id;
		result = prime * result + Float.floatToIntBits(volume);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		if (song_id != other.song_id)
			return false;
		if (Float.floatToIntBits(volume) != Float.floatToIntBits(other.volume))
			return false;
		return true;
	}

	

}
public class Ques2 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		ArrayList<Song> song=new ArrayList<>();

		for(int i=0;;i++)
		{
			System.out.println("Enter Song Id :");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Song Name :");
			String name=sc.nextLine();

			if(song.isEmpty())
			{
				song.add(new Song(id, name, 2));

			}
			else
			{
					Song v=song.get(i-1);
					song.add(new Song(id, name, (v.getVolume()+2)));
					if(song.get(i).getVolume()%3==0)
					{
						Song v1=song.get(i);
						v1.setVolume((v1.getVolume())/2);
						
					}
					if(song.get(i).getVolume()>=10)
					{
						System.out.println("Song Index Whose Volume Is Greater Than Or Equal To 10 : "+(i+1));
						System.out.println("Song id: "+song.get(i).getsong_id()+" Song Name : "+song.get(i).getSongName());
						break;
					}
			}
		}

		for(Song s1:song)
			System.out.println(s1);
		sc.close();
	
	}
}
