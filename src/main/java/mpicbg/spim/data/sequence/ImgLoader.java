package mpicbg.spim.data.sequence;

import java.io.File;

import net.imglib2.RandomAccessibleInterval;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.type.numeric.real.FloatType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ImgLoader
{
	/**
	 * initialize the loader from a &lt;{@value XmlKeys#IMGLOADER_TAG}&gt; DOM element.
	 */
	public void init( final Element elem, final File basePath );

	/**
	 * create a &lt;{@value XmlKeys#IMGLOADER_TAG}&gt; DOM element for this loader.
	 */
	public Element toXml( final Document doc, final File basePath );

	// TODO: TypedImgLoader
	// boolean normalized (FloatType)
	// min max
	// List of ImgLoader

	/**
	 * Get {@link FloatType} image normalized to the range [0,1].
	 *
	 * @param view
	 *            timepoint and setup for which to retrieve the image.
	 * @return {@link FloatType} image normalized to range [0,1]
	 */
	public RandomAccessibleInterval< FloatType > getImage( ViewDescription< ?, ? > view );

	/**
	 * Get {@link UnsignedShortType} un-normalized image.
	 *
	 * @param view
	 *            timepoint and setup for which to retrieve the image.
	 * @return {@link UnsignedShortType} image.
	 */
	public RandomAccessibleInterval< UnsignedShortType > getUnsignedShortImage( ViewDescription< ?, ? > view );
}