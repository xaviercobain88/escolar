/**
 * 
 */
package ec.com.webcreativa.escolar.presentation.datamanager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author galo
 * 
 */
@ManagedBean(name = "exportDM")
@SessionScoped
public class ExportDM {

	private String fileName;

	private String contentType;

	private byte[] bytesArray;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(final String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the bytesArray
	 */
	public byte[] getBytesArray() {
		return bytesArray;
	}

	/**
	 * @param bytesArray
	 *            the bytesArray to set
	 */
	public void setBytesArray(final byte[] bytesArray) {
		this.bytesArray = bytesArray;
	}

}
