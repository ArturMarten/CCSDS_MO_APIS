/* ----------------------------------------------------------------------------
 * Copyright (C) 2013      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : CCSDS MO MAL Java API
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package org.ccsds.moims.mo.mal.structures;

import org.ccsds.moims.mo.mal.MALDecoder;
import org.ccsds.moims.mo.mal.MALEncoder;
import org.ccsds.moims.mo.mal.MALException;

/**
 * Class representing MAL Duration type.
 */
public class Duration implements Attribute
{
  private double value;

  /**
   * Default constructor.
   */
  public Duration()
  {
    value = 0;
  }

  /**
   * Initialiser constructor.
   *
   * @param value Value to initialise with.
   */
  public Duration(final double value)
  {
    this.value = value;
  }

  @Override
  public Element createElement()
  {
    return new Duration();
  }

  /**
   * Returns the value of this type.
   *
   * @return the value.
   */
  public double getValue()
  {
    return value;
  }

//  This might be required for XML serialisation and technologies that use that.  
//  public void setValue(int value)
//  {
//    this.value = value;
//  }

  @Override
  public Long getShortForm()
  {
    return Attribute.DURATION_SHORT_FORM;
  }

  @Override
  public Integer getTypeShortForm()
  {
    return Attribute.DURATION_TYPE_SHORT_FORM;
  }

  @Override
  public UShort getAreaNumber()
  {
    return UShort.ATTRIBUTE_AREA_NUMBER;
  }

  @Override
  public org.ccsds.moims.mo.mal.structures.UOctet getAreaVersion()
  {
    return UOctet.AREA_VERSION;
  }

  @Override
  public UShort getServiceNumber()
  {
    return UShort.ATTRIBUTE_SERVICE_NUMBER;
  }

  @Override
  public void encode(final MALEncoder encoder) throws MALException
  {
    encoder.encodeDuration(this);
  }

  @Override
  public Element decode(final MALDecoder decoder) throws MALException
  {
    return decoder.decodeDuration();
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (null == obj)
    {
      return false;
    }
    if (this == obj)
    {
      return true;
    }
    if (!(obj instanceof Duration))
    {
      return false;
    }
    return this.value == (((Duration) obj).value);
  }

  @Override
  public int hashCode()
  {
    return Double.valueOf(value).hashCode();
  }

  @Override
  public String toString()
  {
    return String.valueOf(value);
  }
  private static final long serialVersionUID = Attribute.DURATION_SHORT_FORM;
}
