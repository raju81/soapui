/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.impl.testondemand;

import java.io.UnsupportedEncodingException;

import com.eviware.soapui.SoapUI;
import com.google.common.base.Charsets;

import flex.messaging.util.URLDecoder;

/**
 * @author Erik R. Yverling
 * 
 *         An AlertSite location for running the Test On Demand.
 */
public class Location
{
	private String code;
	private String name;

	public Location( String code, String name )
	{
		this.code = code;
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		// We'll return the encoded name if the decoding fails
		String decodedName = name;
		try
		{
			decodedName = URLDecoder.decode( name, Charsets.UTF_8.toString() );
		}
		catch( UnsupportedEncodingException e )
		{
			SoapUI.logError( e );
		}
		return decodedName;
	}
}
