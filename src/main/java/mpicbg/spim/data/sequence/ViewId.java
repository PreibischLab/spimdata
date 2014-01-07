package mpicbg.spim.data.sequence;


/**
 * Identifies a particular view as a combination of a {@link TimePoint} id and a
 * {@link ViewSetup} id.
 *
 * @author Tobias Pietzsch <tobias.pietzsch@gmail.com>
 */
public class ViewId implements Comparable< ViewId >
{
	/**
	 * The timepoint id (index).
	 */
	protected final int timepoint;

	/**
	 * The setup id (index within the timepoint).
	 */
	protected final int setup;

	public ViewId( final int timepointId, final int setupId )
	{
		timepoint = timepointId;
		setup = setupId;
	}

	/**
	 * Get the timepoint id (index).
	 *
	 * @return timepoint id
	 */
	public int getTimePointId()
	{
		return timepoint;
	}

	/**
	 * Get the setup id (index within the timepoint).
	 *
	 * @return setup id
	 */
	public int getViewSetupId()
	{
		return setup;
	}

	@Override
	public boolean equals( final Object o )
	{
		if ( o == null )
		{
			return false;
		}
		else if ( o instanceof ViewId )
		{
			final ViewId i = (ViewId)o;
			
			if ( i.getTimePointId() == getTimePointId() && i.getViewSetupId() == getViewSetupId() )
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int compareTo( final ViewId o )
	{
		if ( timepoint == o.timepoint )
			return setup - o.setup;
		else
			return timepoint - o.timepoint;
	}
	
	@Override
	public int hashCode() 
	{
		// some non-colliding hash assuming we have not more that 100000 viewsetups
		return getViewSetupId() + getTimePointId() * 100000;
	}
}